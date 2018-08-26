package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.Teacher;
import srmsystem.domain.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * �����û����UID������password����ɫrole��ѯ��ʦ
	 * @param UID �û����
	 * @param password ����
	 * @param role ��ɫ
	 * @return ����ָ���û����UID������password����ɫrole���û�
	 */
	List<User> findByUID(String UID,String password,int role);
	/**
	 * �����û����UID������password����ɫrole��ѯ��ʦ
	 * @param UID �û����
	 * @param password ����
	 * @param role ��ɫ
	 * @return ����ָ���û����UID������password����ɫrole���û�
	 */
	List<User> findByUser(User user);
}
