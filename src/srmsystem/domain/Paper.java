package srmsystem.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Paper {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paID;
	private String paName;
	private int paLevel;//1����ͨ,2:����,3:EI,4:SCI
	private double paScore;
	private String paApplicant;
	private int paStatus;//0��δ�ύ��1������ˣ�2�����ͨ����3�����δͨ��
	@ManyToMany(targetEntity=RoleScore.class)
	@JoinTable(name="paper_score",
			joinColumns=@JoinColumn(name="paID",referencedColumnName="paID"),
			inverseJoinColumns=@JoinColumn(name="RID",referencedColumnName="RID"))
	private Set<RoleScore> roleScore=new HashSet<>();
	
	public int getPaID() {
		return paID;
	}
	public void setPaID(int paID) {
		this.paID = paID;
	}
	public String getPaName() {
		return paName;
	}
	public void setPaName(String paName) {
		this.paName = paName;
	}
	public int getPaLevel() {
		return paLevel;
	}
	public void setPaLevel(int paLevel) {
		this.paLevel = paLevel;
	}
	public double getPaScore() {
		return paScore;
	}
	public void setPaScore(double paScore) {
		this.paScore = paScore;
	}
	public String getPaApplicant() {
		return paApplicant;
	}
	public void setPaApplicant(String paApplicant) {
		this.paApplicant = paApplicant;
	}
	public int getPaStatus() {
		return paStatus;
	}
	public void setPaStatus(int paStatus) {
		this.paStatus = paStatus;
	}
	public Set<RoleScore> getRoleScore() {
		return roleScore;
	}
	public void setRoleScore(Set<RoleScore> roleScore) {
		this.roleScore = roleScore;
	}
	
}
