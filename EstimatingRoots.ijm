//Ryosuke Tajima 20180205

setAutoThreshold("Triangle");
run("Threshold", "thresholded remaining black"); 
run("Skeletonize");
nBins = 256;
row = 0;
getHistogram(values, counts, nBins);
for (i=0; i<nBins; i++) {
    setResult("Value", row, values[i]);
    setResult("Count", row, counts[i]);
    row++;
    }
TotalCount = counts[0];
RootLength = TotalCount*1.1/400*2.54;
print(RootLength);

