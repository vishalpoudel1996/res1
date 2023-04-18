package customapis;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="My Test Api"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class MyTestApi {
    
    @TestApiParameter(seq=1, 
            summary="The first parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String param1;
    
    @TestApiParameter(seq=2, 
            summary="The second parameter's summary.",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public boolean param2;

    @TestApiParameter(seq=10, 
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String resultName;

    @TestApiParameter(seq=11, 
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;

    /** 
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;
    
    /** 
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    
    @TestApiExecutor
    public void execute() {
    	

String line="";
String s="";
{
        try {
            // Create a ProcessBuilder for the command you want to run
          //  ProcessBuilder builder = new ProcessBuilder("powershell -command", "(Get-Command 'C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe').Version.ToString()");
ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe\" get Version /value");

            // Start the process
            Process process = builder.start();

            // Read the output of the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
               s=line;
                //return line;
            }

            // Wait for the process to finish and get its exit code
            int exitCode = process.waitFor();
            System.out.println("Command exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
           e.printStackTrace();
         s= "error";
          // return s;
            }
        


}


    	
    	
    	
    	
    	
    	
    	
    	
    	
    	

    	// Put our implementation logic here.
    	testLogger.info("Hello from " + this.getClass().getName());

        // Store the result (if appropriate).
    	String dummyResult = this.getClass().getName() + " result";
        testExecutionContext.setValue(resultName, s, resultScope);
        
    }
    
}
