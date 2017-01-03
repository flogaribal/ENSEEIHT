
%Number of simulations
Nens=20;
%Quality of the subspace approximation
percentInfo=0.95;

%Reading the observations
%%%
% TODO: select the file associated to your group number  
% load('observation29.mat');
load('observation.mat');
	  
% Initiatlization	  
Pi=zeros(3,1);

for GWi = 1:3
    %Generation of the data set
    Fi = Model(GWi,Nens);
    
    %Computation of the mean and anomalies 
    mFi= mean(Fi,2);
    Zi=Fi-repmat(mFi,1,Nens);
    
    %%%
    [Ui,Si,Vi] = svd(Zi,0);
    DS = diag(Si);
    if (DS(1)==0)
      disp('Matrix null')
      return
    end

    %%%%
    % TODO: select the vectors associated with the most dominant singular values.
    %       This is done accordingly to Equation (1).
    %%%%
    converged=1;

    while (sum(DS(1:converged) .* DS(1:converged)) / sum(DS.*DS) < percentInfo) 
      converged=converged+1;
    end
    
    Ui = Ui(:,1:converged);
    Vi = Vi(:,1:converged);
    % END TODO
    %%%

    Zobs=Fobs-mFi;
    tmp=(Ui')*Zobs; % to prevent "out of memory" issues 
    Pi(GWi)=norm(Zobs-Ui*tmp);
    
end

figure(1)
bar(Pi)
