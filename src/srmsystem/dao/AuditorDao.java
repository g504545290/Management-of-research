package srmsystem.dao;

import java.util.List;
import common.dao.BaseDao;
import srmsystem.domain.Auditor;

public interface AuditorDao extends BaseDao<Auditor>{
	/**
	 * �������Ա���AID��ѯ���Ա
	 * @param AID ���Ա���
	 * @return ����ָ��AID�����Ա����
	 */
	List<Auditor> findByAIDList(String AID);
	/**
	 * �������Ա���AID��ѯ���Ա
	 * @param AID ���Ա���
	 * @return ����ָ��AID�Ľ�ʦ
	 */
	Auditor findByAID(String AID);
}
