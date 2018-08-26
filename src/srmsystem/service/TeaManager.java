package srmsystem.service;

import java.util.List;
import srmsystem.domain.*;
import srmsystem.vo.*;

//��ʦ����
public interface TeaManager {
	// ��¼ʧ��
	public static final int LOGIN_FAIL = 2;
	// �Խ�ʦ��ݵ�¼
	public static final int LOGIN_TEA = 1;
	
	String findTID(String TName);
	/**
	 * �Ծ����������֤��¼
	 * @param user ��¼�ľ������
	 * @return ��¼������ȷ��:0Ϊ��¼ʧ�ܣ�1Ϊ��¼���Ա 2Ϊ��¼��ʦ
	 */
	int validLogin(User user);
	/** 
	 * ͨ����ʦ��ŷ��ؽ�ʦ��Ϣ
	 * TID:��ʦ���
	 */
	List<TeacherBean> GetTeaScore(String TID);
	/**
	 * �������ķ���
	 * @param mem���ĳ�Ա
	 * @param paLevel���ļ���
	 * @param mem���ĳ�Ա
	 * @return
	 */
	double markPaper(List<String> mem,int paLevel,String applicant);
	/**
	 * ������Ŀ����
	 * @param prLevel��Ŀ����
	 * @param prFunding��Ŀ�ʽ�
	 * @return
	 */
	double markProject(List<String> mem,int prLevel,double prFunding,String applicant);
	/**
	 * �жϽ�ʦ��������Ƿ���Ϲ���
	 * @param roleScoreÿ����Ա��Ӧ����,��һ����Ӧ�����˷����������Ӧ�����߷���
	 * @param Score��Ŀ�ܷ�
	 * @return ���Ϲ��򷵻�true������ false
	 */
	boolean judgeAssignProject(List<RoleScore> roleScore,double Score);
	/**
	 * �жϽ�ʦ��������Ƿ���Ϲ���
	 * @param roleScoreÿ����Ա��Ӧ��������һ����Ӧһ�������������Ӧ��������
	 * @return ���Ϲ��򷵻�true������ false
	 */
	boolean judgeAssignPaper(List<RoleScore> roleScore,double paperScore);
	/**
	 * @param paName ��������
	 * @param paLevel ���ļ���
	 * @param paperScore ���ķ���
	 * @param paApplicant �걨�˱��
	 * @param paStatus ����״̬
	 * @param roleScore ��ɫ-������
	 * @param PaScore ÿ����Ա��Ӧ����
	 * @return 1��ӳɹ���0���ʧ��
	 */
	int savePaper(String paName,int paLevel,double paperScore,String paApplicant,
			int paStatus,List<RoleScore> roleScore);
	/**
	 * 
	 * @param prName ��Ŀ����
	 * @param prLevel ��Ŀ����
	 * @param prFunding ��Ŀ�ʽ�
	 * @param projectScore ��Ŀ����
	 * @param prApplicant �걨�˱��
	 * @param prStatus ��Ŀ״̬
	 * @param roleScore ��Ŀ��ɫ-������
	 * @param PrScore ÿ����Ա��Ӧ����
	 * @return 1��ӳɹ���0���ʧ��
	 */
	int saveProject(String prName,int prLevel,double prFunding,double projectScore,
			String prApplicant,int prStatus,List<RoleScore> roleScore);
	/** 
	 * @param paName ��������
	 * @param paLevel ���ļ���
	 * @param paperScore ���ķ���
	 * @param paApplicant �걨�˱��
	 * @param paStatus ����״̬
	 * @param roleScore ��ɫ-������
	 */
	int applyPaper(String paName,int paLevel,double paperScore,String paApplicant,
			int paStatus,List<RoleScore> roleScore);
	/**
	 *@param prName ��Ŀ����
	 * @param prLevel ��Ŀ����
	 * @param prFunding ��Ŀ�ʽ�
	 * @param projectScore ��Ŀ����
	 * @param prApplicant �걨�˱��
	 * @param prStatus ��Ŀ״̬
	 * @param roleScore ��Ŀ��ɫ-������
	 */
	int applyProject(String prName,int prLevel,double prFunding,double projectScore,
			String prApplicant,int prStatus,List<RoleScore> roleScore);
	/**
	 *���������˲�ѯ������Ϣ
	 *@param paApplicant ����������
	 */
	List<PaperBean> findPaper(String paApplicant);
	/**
	 *���������˲�ѯ������Ϣ
	 *@param prApplicant ��Ŀ������
	 */
	List<ProjectBean> findProject(String prApplicant);
	/**
	 *���ݽ�ʦ��Ų�ѯ������Ϣ
	 */
	List<PaperBean> findPaperScore(String TID);
	/**
	 *���ݽ�ʦ��Ų�ѯ������Ϣ
	 */
	List<ProjectBean> findProjectScore(String TID);
}
