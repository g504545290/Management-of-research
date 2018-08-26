package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.*;

public interface TeacherDao extends BaseDao<Teacher>{
	/**
	 * ���ݽ�ʦ��Ų�ѯ��ʦ
	 * @param TID ��ʦ���
	 * @return ����ָ��TID�Ľ�ʦ����
	 */
	List<Teacher> findByTIDList(String TID);
	/**
	 * ���ݽ�ʦ��Ų�ѯ��ʦ
	 * @param TID ��ʦ���
	 * @return ����ָ��TID�Ľ�ʦ
	 */
	Teacher findByTID(String TID);
	/**
	 * ���ݽ�ʦ��Ų�ѯ��ʦ
	 * @param TID ��ʦ���
	 * @return ����ָ��TID�Ľ�ʦ����
	 */
	List<Teacher> findByNameList(String TName);
	/**
	 * ���ݽ�ʦ��Ų�ѯ��ʦ
	 * @param TID ��ʦ���
	 * @return ����ָ��TID�Ľ�ʦ
	 */
	Teacher findByName(String TName);
	/**
	 * ��ѯ���н�ʦ
	 */
	List<Teacher> find();
}
