package pixelDrain;

import java.io.File;

import javax.swing.UIManager;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class PixelDrain {
	public static void main(String[] args) throws Exception{
		
		File uploadDir = new File("uploads");
		// if the directory does not exist, create it
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		// Sadly, UIManager.getSystemLookAndFeelClassName() will never return GTK
		
		
		trayMenu tray = new trayMenu();
		tray.create();
		
		GUI.optionFrame();
		
		try {
            GlobalScreen.registerNativeHook();
	    }
	    catch (NativeHookException ex) {
	            System.err.println("It is not my fault");
	            System.err.println(ex.getMessage());
	    }
	
	    //Create the key listener
	    GlobalScreen.getInstance().addNativeKeyListener(new keyListener());
	    
	    while(true){
	    	Thread.sleep(60000);
	    }
	}
}