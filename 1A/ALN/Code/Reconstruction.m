%%% Set check to true for validation %%%
check=true;

% Number of simulations
%%%
% TODO : assess the impact fot this parameter on the results
% of the reconstruction
Nens = 50;

% Wind parameter
GW = 1;
% Stopping criterions 
maxIter=100;
epsilon=1.e-8;
% TODO : assess the impact of this parameter on the results
% of the reconstruction
percentInfo = 0.95;

% Generate the simulations
F = Model(GW,Nens);

% Ensemble mean
muF = mean(F,2);
% Compute the anomaly matrix
Z   = F - repmat(muF,1,Nens);

%%%%%%%  Compute the SVD of A    %%%%%%%
if (check)  
  [U,S,V] = svd(Z,0);
  D = diag(S);
  if (D(1)==0)
    disp('Alert: the matrix is null')
    return
  end
  %%%%
  % TODO: select the vectors associated with the most dominant singular values.
  %       This is done accordingly to Equation (1).
  %%%%
  converged=1;
  
  % Tant que le quotient est inférieur au pourcentage requis
  while (sum(D(1:converged) .* D(1:converged)) / sum(D.*D) < percentInfo)
      % On rajoute une valeur singulière à prendre en compte
      converged=converged+1;
  end
  
  U = U(:,1:converged);
  V = V(:,1:converged);
  fprintf('dimension of the subspace: %d\n',converged);
  % END TODO
  %%%
else
  %%%%
  % TODO: power iteration method
  %%%%
 
  p = 5;
  m = 8;
  tic;
  
  n = length(Z(:,1));  
  V = zeros(n,m);
  
  for k = 1:m
    V(k,k) = 1;
  end
  converged = 0;
  iter = 0;  
  condition = 0;
  while((converged < m) && (iter < maxIter)) 
    iter = iter + 1;
    
    % Calcul Y=(A*A')^p*V
    Y = V;
    for k = 1:p
      Y = Z*((Z')*Y);
    end
   
    % Gram-Schmidt orthogonalisation
    V = Y;
    for i = 1:m
       for j = 1:i-1
    	  s = V(:,j)'*V(:,i);
          V(:,i) = V(:,i) - s*V(:,j);
       end
       V(:,i) = V(:,i)/norm(V(:,i));
    end
  
    % Rayleigh quotient
    H=(V')*(Z*((Z')*V));
  
    % Valeur propres de H
    [Ens,dns] = eig(H);
    [d,index] = sort(diag(dns),'descend');
    E = Ens(:,index);
   
    % V = V*X
    V = V*E; 
  
    % Check wich are the eigenvalues that have converged 
    conv = 0;
    for i = converged + 1:m
      res = norm(Z*((Z')*V(:,i))-d(i)*V(:,i),'fro')/norm(Z,'fro'); 
      if (res > epsilon)
        break
      end
      conv = conv + 1;
      s(i) = sqrt(d(i));
      condition = 1-s(i)/s(1);       
    end
    converged = converged+conv;
    U = V(:,1:converged-1);
    time = toc;
  
    % Critère d'arrêt
    if(condition > percentInfo)
      disp('Convergence')
      break
    end  
    
  end 
    
    fprintf(['%d singular values were found in %7.3f seconds ; they ' ...
             'provide %3.2f%% variability.\n'],converged,time, condition);
 

end


%%%%%%%       Reconstruction        %%%%%%%
[X, ns, nt] = Model(GW,1);
X0 = X(1:ns,:);
%%%%
% TODO: reconstruct X with X0
Zp = zeros(size(X)); 
%%%%
Z0=X0-muF(1:ns);
%alpha=(U(1:ns,:)'*U(1:ns,:))\(U(1:ns,:)'*Z0);

% Restriction de U en U0
U0= U(1:ns,:);

% Factorisation QR de UO 
[Q,R] = qr(U0);

% Résolution du système 
alpha=R\(Q'*Z0);

% Calcul de Zp
Zp=U*alpha;

%%%% Compute the error %%%%
Xp = Zp + muF;
error=norm(Xp-X)/norm(X);
fprintf('error = %f\n',error);

%%%% Display %%%%
global Lx Ly Nx Ny;

% draw result
    x = linspace(0,Lx,Nx);     %  Independent variable x
    y = linspace(0,Ly,Ny);     %  Independent variable y
    [Mx, My] = meshgrid(x,y);  %  2D arrays, mainly for plotting
    Mx = Mx'; My = My';        %  MatLab is strange!

      figure(2)
     
 for tt=1:nt
          set(gcf,'Renderer','Painters')
          subplot(1,2,1);
          z = X((tt-1)*ns+1:tt*ns,1);
          z = reshape(z,Nx,Ny);
          surf(Mx,My,z); shading('interp');
          axis([0,Lx,0,Ly ,5000,6000]);
	  pbaspect([3 1 3])
	  title('Solution')
	  
      
          subplot(1,2,2);
          zappr = Xp((tt-1)*ns+1:tt*ns,1);
          zappr = reshape(zappr,Nx,Ny);
          h2=surf(Mx,My,zappr); shading('interp');
	  axis([0,Lx,0,Ly ,5000,6000]);
	  pbaspect([3 1 3])
	  title('Reconstruction') 
         drawnow	 
  end
