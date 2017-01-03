function rvec = res_GPS(ti, tui, Pi, Pu,  tho, nbSat, celerite)

rvec = zeros(nbSat, 1);

for i=1:nbSat 
    rvec(i) = norm(Pu-Pi(:,i)) - celerite * (tui(i)-tho-ti(i));
end