package srmsystem.dao;

import java.util.List;

import common.dao.BaseDao;
import srmsystem.domain.*;

public interface RoleScoreDao extends BaseDao<RoleScore>{
	/**
	 * ���ݱ�Ų�ѯ
	 * @param RID ���
	 * @return ����ָ��RID�Ľ�ɫ��������
	 */
	List<RoleScore> findByRIDList(int RID);
	/**
	 * ���ݱ�Ų�ѯ
	 * @param RID ���
	 * @return ����ָ��RID�Ľ�ɫ����
	 */
	RoleScore findByRID(int RID);
	/**
	 * ���ݽ�ʦ��Ų�ѯ
	 * @param TID ��ʦ���
	 * @return ����ָ��TID�Ľ�ɫ��������
	 */
	//List<RoleScore> findByTID(String TID);
	List<RoleScore> findByTeacher(Teacher teacher);
	/**
	 * ���ݽ�ʦ��š���ʦ��ɫ����ʦ������ѯ
	 * @param TID ��ʦ���
	 * @param TRole ��ʦ��ɫ
	 * @param score ��ʦ����
	 * @return ����ָ��TID�Ľ�ɫ��������
	 */
	//List<RoleScore> findByTIDTRoleScore(String TID,int TRole,double score);
	List<RoleScore> find(Teacher teacher,int TRole,double score);
	/**
	 * ���ݽ�ʦ��š���ʦ��ɫ����ʦ������ѯ
	 * @param TID ��ʦ���
	 * @param TRole ��ʦ��ɫ
	 * @return ����ָ��TID�Ľ�ɫ��������
	 */
	List<RoleScore> findByTeacher(Teacher teacher,int TRole);
}
