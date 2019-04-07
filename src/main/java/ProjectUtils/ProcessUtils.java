package ProjectUtils;

import java.io.IOException;



public class ProcessUtils {



	public static Process process;
	
	public static Runtime runtime = Runtime.getRuntime();

	
	public static void startGrid(String sh_file_path) {

		try{


			process = runtime.exec(new String[]{"/bin/bash", "-c", sh_file_path});


		}catch(Exception e){


			System.out.println(e.getMessage());

		}

	}



	public static void killProcess() {

		try {


			process = runtime.exec(new String[]{"/bin/bash", "-c", "kill -9 $(lsof -t -i:4444)"});


		} catch (IOException e) {


			System.out.println("io exception");

		}
	}


}
