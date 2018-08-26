package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.*;

public interface ProjectDao extends BaseDao<Project>{
	/**
	 * ������Ŀ��Ų�ѯ
	 * @param prID ��Ŀ���
	 * @return ����ָ��prID����Ŀ����
	 */
	List<Project> findByprIDList(int prID);
	/**
	 * ������Ŀ��Ų�ѯ
	 * @param prID ��Ŀ���
	 * @return ����ָ��prID����Ŀ
	 */
	Project findByprID(int prID);
	/**
	 * ���������˱�Ų�ѯ
	 * @param prApplicant �����˱��
	 * @return ����ָ��prApplicant����Ŀ����
	 */
	List<Project> findByprApplicant(String prApplicant);
	/**
	 * ����״̬��ѯ
	 * @param prStatus ����״̬
	 * @return ����ָ��prStatus�����ļ���
	 */
	List<Project> findByprStatus(int prStatus);
	/**
	 * ������Ŀ��Ų�ѯ
	 * @param prName ��Ŀ��Ŀ
	 * @return ����ָ��prName����Ŀ����
	 */
	List<Project> findByprName(String prName);
}
