package model;

public class UserBean
{
	private String username = "";
	private String password = "";
	
	public UserBean(){}
	
	public String getUserName(){return username;}
	public void setUserName(String username){this.username = username;}
	
	public String getPassword(){return password;}
	public void setPassword(String password){this.password = password;}
    
    public String checkValid()
    {
        if(username.length() == 0)
            return "Set User name";
        else if(password.length() == 0)
            return "Set Password";
        else if(!username.equals("amir") || !password.equals("abc123"))
            return "User name or password doesn't match";
        
        return "valid";
    }
}