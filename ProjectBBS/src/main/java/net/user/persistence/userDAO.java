package net.user.persistence;

import net.user.domain.userVO;

public interface userDAO {
	void register(userVO userVO) throws Exception;
}
