clear all;
close all;
load picture.mat
colormap('gray');
subplot(2,3,1)
image(X)
title('image originale - compression 1 ');
axis off
