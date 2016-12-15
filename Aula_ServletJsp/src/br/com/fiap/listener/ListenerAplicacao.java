package br.com.fiap.listener;

import java.io.FileWriter;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ListenerAplicacao implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    public ListenerAplicacao() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	gerarLog("Sessão criada");
    }

    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
    	gerarLog("Atributo removido");
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	gerarLog("Sessão destruida");
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	gerarLog("Contexto destruido");
    }

    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
    	gerarLog("Atributo adicionado");
    }

    public void attributeReplaced(ServletRequestAttributeEvent arg0)  {
    	gerarLog("Atributo alterado");
    }

    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	gerarLog("Atributo adicionado");
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	gerarLog("Atributo removido");
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  {
    	HttpSession session = arg0.getSession();
    	String id = session.getId();
    	gerarLog(String.format("Atributo %s = %s alteardo na sessao id = %s", arg0.getName(),arg0.getValue(),id));
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	gerarLog("Contexto Iniciado");
    }
	
    private void gerarLog(String msg) {
    	try {
			FileWriter writer = new FileWriter("D:/28SCJ/arquivos/log.txt",true);
			writer.write(String.format("[%s] - %s\r\n", new Date(), msg));
			writer.close();
		} catch (Exception e) {
			System.out.println("erro ao logar...");
		}
	}
}
