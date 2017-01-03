clear all
close all
n=4;
U=gallery('orthog',n)
D=diag(ones(n,1));
i=1;
for k=1:16
  D(1,1) = power(10,k) ;
  A=U*D*U';

  %Gram-Schmidt classique 
  Qcgs=cgs(A);

  %Gram-Schmidt modifié
  Qmgs = mgs(A);

  po(1,k)=norm(eye(n)-Qcgs'*Qcgs);
  po(2,k)=norm(eye(n)-Qmgs'*Qmgs);
end
semilogy(po(1,:),'r')
hold on
semilogy(po(2,:),'b')
legend('CGS','MGS');
xlabel('logarithm of the condition number of A_k')
ylabel('|| I - Q_k^TQ_k ||')
