package srmsystem.dao;

import java.util.List;

import common.dao.BaseDao;
import srmsystem.domain.*;

public interface PaperDao extends BaseDao<Paper>{
	/**
	 * �������ı�Ų�ѯ
	 * @param paID ���ı��
	 * @return ����ָ��paID�����ļ���
	 */
	List<Paper> findBypaIDList(int paID);
	/**
	 * �������ı�Ų�ѯ
	 * @param paID ���ı��
	 * @return ����ָ��paID������
	 */
	Paper findBypaID(int paID);
	
	/**
	 * ���������˱�Ų�ѯ
	 * @param paApplicant �����˱��
	 * @return ����ָ��paApplicant�����ļ���
	 */
	List<Paper> findBypaApplicant(String paApplicant);
	/**
	 * ����״̬��ѯ
	 * @param paStatus ����״̬
	 * @return ����ָ��paStatus�����ļ���
	 */
	List<Paper> findBypaStatus(int paStatus);
	
	/**
	 * �������ı�Ų�ѯ
	 * @param paName ������Ŀ
	 * @return ����ָ��paName�����ļ���
	 */
	List<Paper> findBypaName(String paName);
	
}
