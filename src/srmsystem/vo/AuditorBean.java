package srmsystem.vo;

import java.io.Serializable;

//���Ա

public class AuditorBean implements Serializable {
	private String AID;// ���
	private String AName;// ����
	// �޲����Ĺ�����

	public void auditorBean() {

	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public AuditorBean(String aID, String aName) {
		super();
		AID = aID;
		AName = aName;
	}

	// setter��getter����
	public String getAID() {
		return AID;
	}

	public void setAID(String aID) {
		AID = aID;
	}

	public String getAName() {
		return AName;
	}

	public void setAName(String aName) {
		AName = aName;
	}

}
