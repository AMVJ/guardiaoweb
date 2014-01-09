package br.com.guardiao.ftp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import br.com.guardiao.modelo.Camera;

public class FTPConnect implements Serializable{

	private String mensagem;
	private Boolean exibeMensagem;
	private Long contador = 0L;
	private boolean buttonRendered = true;
    private boolean enabled=false;
	private Camera camera;
      
      public String conectarFtp() {
    	  int port = 21;
    	  //String server = "127.0.0.1";
    	  //String user = "ramon";
    	  //String pass = "123456";
    	  
          FTPClient ftpClient = new FTPClient();
          try {
        	  
        	  setEnabled(true);
              setButtonRendered(false);
   
              ftpClient.connect(camera.getDsFtpCamera(), port);
              ftpClient.login(camera.getNmLoginCamera(), camera.getNmSenhaCamera());
              ftpClient.enterLocalPassiveMode();
              ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
              String[] arq = ftpClient.listNames();
   
              // APPROACH #1: using retrieveFile(String, OutputStream)
              /*
              for (String f : arq) {
            	  String remoteFile1 = f;
            	  File downloadFile1 = new File("C://down//"+f);
            	  OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
            	  boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
            	  outputStream1.close();
            	  
            	  if (success) {
            		  System.out.println("Download do arquivo "+f+" realizado com sucesso.");
            		  setMensagem(mensagem+"n/Download do arquivo "+f+" realizado com sucesso.");
            		  exibeMensagem=true;
            	  }
				
              }
   
   */
              // APPROACH #2: using InputStream retrieveFileStream(String)
              for (String f : arq) {
	              String remoteFile2 = f;
	              File downloadFile2 = new File("C://down//"+f);
	              OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
	              InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
	              boolean success;
	              byte[] bytesArray = new byte[4096];
	              int bytesRead = -1;
	              while ((bytesRead = inputStream.read(bytesArray)) != -1) {
	                  outputStream2.write(bytesArray, 0, bytesRead);
	                  contador=contador+1;
	              }
	   
	              success = ftpClient.completePendingCommand();
	              if (success) {
	        		  System.out.println("Download do arquivo "+f+" realizado com sucesso.");
	        		  if(getMensagem() != null)
	        			  setMensagem(mensagem+"<br />Download do arquivo "+f+" realizado com sucesso.");
	        		  else
	        			  setMensagem("Download do arquivo "+f+" realizado com sucesso.");
	        			  
            		  exibeMensagem=true;
	              }
	              outputStream2.close();
	              inputStream.close();
              }
   
          } catch (IOException ex) {
              System.out.println("Error: " + ex.getMessage());
              ex.printStackTrace();
          } finally {
              try {
                  if (ftpClient.isConnected()) {
                      ftpClient.logout();
                      ftpClient.disconnect();
                  }
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
          }
		return null;
      }
      

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Boolean getExibeMensagem() {
		return exibeMensagem;
	}

	public void setExibeMensagem(Boolean exibeMensagem) {
		this.exibeMensagem = exibeMensagem;
	}


	public Long getContador() {
		return contador;
	}


	public void setContador(Long contador) {
		this.contador = contador;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Boolean getButtonRendered() {
		return buttonRendered;
	}


	public void setButtonRendered(Boolean buttonRendered) {
		this.buttonRendered = buttonRendered;
	}


	public br.com.guardiao.modelo.Camera getCamera() {
		return camera;
	}


	public void setCamera(br.com.guardiao.modelo.Camera camera) {
		this.camera = camera;
	}
}