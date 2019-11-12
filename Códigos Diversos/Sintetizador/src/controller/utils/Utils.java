package controller.utils;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Utils {
	public static void handleProcedure(Procedure procedure, boolean printStackTrace) {
		try {
			procedure.invoke();
		} catch (Exception e) {
			if (printStackTrace) {
				e.printStackTrace();
			}
		}
	}
	
	public static class WindowDesign{
		public static final Border BORDA_LINHA = BorderFactory.createLineBorder(Color.BLUE);
	}
	
	public static class Math{
		public static double frequenciaParaFrequenciaAngular(double freq) {
			
			return 2 * java.lang.Math.PI * freq;
		}
	}
}
