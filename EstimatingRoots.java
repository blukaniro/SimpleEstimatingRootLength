//Ryosuke Tajima 20180205

import ij.*;
import ij.process.*;
import ij.gui.*;
import ij.plugin.*;
import java.io.*;

public class Estimating_Roots implements PlugIn
{
	ImagePlus imp;
	public void run(String arg)
	{
		if(getDpi())
			return ;
		measurement();
	}

	public void measurement()
	{
		IJ.getImage().getProcessor().setAutoThreshold("Triangle");
		IJ.run("Threshold", "thresholded remaining black");
		IJ.run("Skeletonize");
		ImageProcessor ip = IJ.getImage().getProcessor();
		int [] hist = ip.getHistogram();
		double TL = hist[0];
		double RL = TL/DPI*2.54*1.1;
		IJ.log("RootLength" + "\t"  + RL);
	}

	static double DPI = 400;
	private boolean getDpi()
	{
		GenericDialog gd = new GenericDialog("DPI", IJ.getInstance());
		gd.addNumericField("DPI", DPI, 0);
		gd.showDialog();
		if (gd.wasCanceled())
		{
			return true;
		}
		DPI = (double) gd.getNextNumber();
		return false;
	}
}

