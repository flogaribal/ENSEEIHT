%%% Set check to true for validation %%%
check=true;

% Number of simulations
%%%
% TODO : assess the impact fot this parameter on the results
% of the reconstruction
Nens = 50;

% Wind parameter
GW = 1;

% TODO : assess the impact of this parameter on the results
% of the reconstruction
percentInfo = 0.10;

% Generate the simulations
F = Model(GW,Nens);

% Ensemble mean
muF = mean(F,2);
% Compute the anomaly matrix
Z   = F - repmat(muF,1,Nens);

%%%%%%%  Compute the SVD of A    %%%%%%%
if (check)  
  tic;
  [U,S,V] = svd(Z,0);
  d = diag(S);
  if (d(1)==0)
    disp('Alert: the matrix is null')
    return
  end
 
  % Trace of Z*Z'
  normZ2=norm(Z,'fro')^2;
  converged=0;
  condition=0;
  n=length(Z(:,1));  
  
  while((condition<=percentInfo)&&(converged<n))
    converged=converged+1;
    condition=condition+d(converged)^2/normZ2;  
  end 

  U = U(:,1:converged);
  V = V(:,1:converged);
  time=toc;
  fprintf(['%d singular values were found in %7.3f seconds ; they ' ...
             'provide %3.2f%% variability.\n'],converged,time, condition);
else
  addpath('Fortran') 
  p=6;
  m=10;
  maxit=300;
  eps=1.e-8;
  tic;
  [U,d,V] = fortran_subspace_iter_sv(Z,m,p,percentInfo,eps,maxit);
  time=toc;
  
  normZ2=norm(Z,'fro')^2;
  converged=size(d,1);
  condition=sum(d.^2)/normZ2;
  
  fprintf(['%d sing. values found in %7.3f seconds ; they ' ...
           'provide %3.2f%% variability. \n'], converged, time,condition);
 
end


%%%%%%%       Reconstruction        %%%%%%%
[X, ns, nt] = Model(GW,1);
X0 = X(1:ns,:);
%%%%
% TODO: reconstruct X with X0
Zp = zeros(size(X)); 
%%%%
Z0=X0-muF(1:ns);
alpha=(U(1:ns,:)'*U(1:ns,:))\(U(1:ns,:)'*Z0);
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
