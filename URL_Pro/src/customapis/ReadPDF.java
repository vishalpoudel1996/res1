package customapis;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Read PDF"
, summary=""
, remarks=""
, iconBase=""
, defaultApiGroups={"Custom"}
		)
@TestApiParameterGroups(parameterGroups={
		@TestApiParameterGroup(groupName="inputs", title="Inputs"),
		@TestApiParameterGroup(groupName="result", title="Result"),
})
public class ReadPDF {

	@TestApiParameter(seq=1, 
			summary="The first parameter's summary.",
			remarks="",
			mandatory=true,
			parameterGroup="inputs")
	public String fileName;

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
	public void execute() throws Exception {

		// Put our implementation logic here.
		testLogger.info("Running " + this.getClass().getName());
		String PDFContent=null;
		String filePath=null;
		String currentDir=System.getProperty("user.home")+File.separator+ "Downloads";	
		testLogger.info(currentDir);

		File dir = new File(currentDir);
		File[] dirFileList =  dir.listFiles();

		for(int i=0;i<dirFileList.length;i++)
		{
			if(dirFileList[i].getName().equalsIgnoreCase(fileName))

			{
				Path srcPath= Paths.get(dirFileList[i].getAbsolutePath());
				filePath=srcPath.toString();
				testLogger.info(filePath);			
			}
		}
		File file = new File(filePath);
		PDDocument document = Loader.loadPDF(file);
		//Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		//Retrieving text from PDF document
		PDFContent = pdfStripper.getText(document);	
		testLogger.info(PDFContent);
		//Closing the document
		document.close();	

		// Store the result (if appropriate).
		testExecutionContext.setValue(resultName, PDFContent, resultScope);


	}

}
