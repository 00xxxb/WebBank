package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail1 {
	/**
	 * 设置QQ邮箱服务器
	 */
	public static final String QQSERVER="smtp.qq.com";
	
	/**
	 * 设置网易邮箱服务器
	 */
	public static final String NTESSERVER="smtp.163.com";
	/**
	 * 发件人账户名(地址)
	 */
	private String senderAccount;
	/**
	 * 邮箱授权码
	 */
	private String authcode;
	/**
	 * 邮箱服务器地址
	 */
	private String serverURL;
	/**
	 * 是否打开邮箱调试模式
	 */
	private boolean isDebug;
	
	/**
	 * 获取对象并初始化邮箱参数
	 * 
	 * @param senderAccount 发件人账户名
	 * @param senderAccount 邮箱授权码
	 * @param senderAccount 邮箱服务器地址
	 */
	public JavaMail1(String senderAccount, String authcode, String serverURL) {
		this.senderAccount = senderAccount;
		this.authcode = authcode;
		this.serverURL = serverURL;
	}
	/**
	 * 初始化邮件对象
	 */
	public JavaMail1() {
		
	}
	/**
	 * 发送邮箱
	  * <p>使用此方法之前，必须先<strong>初始化邮箱参数</strong></p>
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param receiver 邮件接收人
     * @throws Exception
	 */
	 public void sendMail(String subject, String content, String receiver) throws Exception {
	    	// 验证邮箱核心配置合法性
		    veriftyCoreConfig(receiver);
	        Session session = Session.getInstance(getInitConfig());
	        if(isDebug) {
	        	session.setDebug(true);
	        }
	        Message msg = getMimeMessage(session, subject, content, receiver);
	        Transport transport = session.getTransport();
	        // 设置发件人的账户名和密码
	        transport.connect(senderAccount, authcode);
	        // 发送邮件
	        transport.sendMessage(msg, msg.getAllRecipients());
	        // 关闭邮件连接
	        transport.close();
	    }
	 private void veriftyCoreConfig(String receiver) {
	    	if(senderAccount == null || senderAccount.trim().length() <= 0) {
	    		throw new RuntimeException("senderAccount incomplete");
	    	}
	    	if(authcode == null || authcode.trim().length() <= 0) {
	    		throw new RuntimeException("authcode incomplete");
	    	}
	    	// 不存在使用QQ邮箱作为默认值
	    	if(serverURL == null || serverURL.trim().length() <= 0) {
	    		serverURL= QQSERVER;
	    	}
	 }
	 /**
	     * 连接邮件服务器的参数配置
	     *
	     * @return config 邮箱配置信息
	     */
	    private Properties getInitConfig() {
	        Properties config = new Properties();
	        // 设置发件人的SMTP服务器地址
	        config.setProperty("mail.host", serverURL);
	        config.setProperty("mail.transport.protocol", "smtp");
	        // 设置用户的认证方式
	        config.setProperty("mail.smtp.auth", "true");
	        config.setProperty("mail.smtp.ssl.enable", "true");
	        config.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        //config.setProperty("mail.smtp.port", "465");
	        config.setProperty("mail.smtp.socketFactory.port", "465");
	        return config;
	    }
	    /**
	     * 获得创建一封邮件的实例对象
	     *
	     * @param session
	     * @return MimeMessage
	     * @throws MessagingException
	     * @throws AddressException
	     */
	    protected MimeMessage getMimeMessage(Session session, String subject, String content, String recipientAddress)
	            throws Exception {
	        MimeMessage msg = new MimeMessage(session);
	        // 设置发件人地址
	        msg.setFrom(new InternetAddress(senderAccount));
	        msg.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(recipientAddress));
	        // 设置邮件主题/正文
	        msg.setSubject(subject, "UTF-8");
	        msg.setContent(content, "text/html;charset=UTF-8");
	        return msg;
	    }
	    
	    /**
	     * 设置发件人账户
	     * @return senderAccount
	     */
	    public String getSenderAccount() {
	        return senderAccount;
	    }
	    
	    /**
	     * 设置邮箱发送地址(发件人账户)
	     * 
	     * @param senderAccount 发件人地址(账户)
	     */
	    public void setSenderAccount(String senderAccount) {
	        this.senderAccount = senderAccount;
	    }
	    
	    /**
	     * 获取授权码
	     * 
	     * @return authcode
	     */
	    public String getAuthcode() {
	        return authcode;
	    }
	    
	    /**
	     * 设置邮箱授权码
	     * 
	     * @param authcode 邮箱授权码
	     */
	    public void setAuthcode(String authcode) {
	        this.authcode = authcode;
	    }
	    
	    /**
	     * 获取当前邮箱服务器地址
	     * 
	     * @return serverURl 服务器邮箱地址
	     */
	    public String getServerURL() {
	        return serverURL;
	    }
	    
	    /**
	     * 设置邮箱服务器地址
	     * 
	     * <p>默认为QQ邮箱</p>
	     * @param serverURL 邮箱服务器地址
	     */
	    public void setServerURL(String serverURL) {
	        this.serverURL = serverURL;
	    }
	    
	    /**
	     * 是否打开邮箱debug模式
	     * 
	     * @return isDebug
	     */
		public boolean isDebug() {
			return isDebug;
		}
		
		/**
		 * 设置邮箱发送debug
		 * 
		 * @param isDebug 是否打开debug
		 */
		public void setDebug(boolean isDebug) {
			this.isDebug = isDebug;
		}
}
