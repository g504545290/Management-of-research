package srmsystem.vo;

import java.io.Serializable;

//�û�

public class UserBean implements Serializable{
    private String UID;//�û����
    private String password;//����
    private String role;//��ɫ
    //�޲ι���
    public void AppBean(){
	  
    }
	//���ι���
	public UserBean(String uID, String password, String role) {
		super();
		UID = uID;
		this.password = password;
		this.role = role;
	}
    //get set����
	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
