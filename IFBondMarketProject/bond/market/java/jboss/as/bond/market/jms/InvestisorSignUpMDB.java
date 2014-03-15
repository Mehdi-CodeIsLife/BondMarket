package jboss.as.bond.market.jms;

import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@SuppressWarnings("serial")
public class InvestisorSignUpMDB implements MessageDrivenBean, MessageListener{
	
	 private MessageDrivenContext ctx = null;
     private QueueConnection conn;
     private QueueSession session;
	
	@Override
	public void onMessage(Message msg) {
		System.out.println("TextMDB.onMessage, this="+hashCode());
        try {
            TextMessage tm = (TextMessage) msg;
            String text = tm.getText() + "processed by: "+hashCode();
            Queue dest = (Queue) msg.getJMSReplyTo();
            sendReply(text, dest);
        } catch(Throwable t) {
            t.printStackTrace();
        }
		
	}

	@Override
	public void ejbRemove() throws EJBException {
		 System.out.println("TextMDB.ejbRemove, this="+hashCode());
	        setCtx(null);
	        try {
	            if (session != null) {
	                session.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch(JMSException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void setMessageDrivenContext(MessageDrivenContext ctx)
			throws EJBException {
		this.setCtx(ctx);
        System.out.println("TextMDB.setMessageDrivenContext, this=" + 
                           hashCode());
	
	}
	
	public void ejbCreate(){
        System.out.println("TextMDB.ejbCreate, this="+hashCode());
        try {
            setupPTP();
        } catch (Exception e) {
            throw new EJBException("Failed to init TextMDB", e);
        }
    }
	
	 private void setupPTP()throws JMSException, NamingException{
        InitialContext iniCtx = new InitialContext();
        Object tmp = iniCtx.lookup("java:comp/env/jms/QCF");
        QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;
        conn = qcf.createQueueConnection();
        session = conn.createQueueSession(false,
                                          QueueSession.AUTO_ACKNOWLEDGE);
        conn.start();
    }

    private void sendReply(String text, Queue dest)
        throws JMSException
    {
        System.out.println("TextMDB.sendReply, this=" + 
                           hashCode() + ", dest="+dest);
        QueueSender sender = session.createSender(dest);
        TextMessage tm = session.createTextMessage(text);
        sender.send(tm);
        sender.close();
    }

	public MessageDrivenContext getCtx() {
		return ctx;
	}

	public void setCtx(MessageDrivenContext ctx) {
		this.ctx = ctx;
	}

}
