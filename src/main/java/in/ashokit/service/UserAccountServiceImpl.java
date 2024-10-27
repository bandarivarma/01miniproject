package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entities.UserAccount;
import in.ashokit.repository.UserAccountRepo;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	@Autowired
	UserAccountRepo userAccRepo;

	@Override
	public String saveOrUpdateUserAcc(UserAccount userAcc) {
		Integer userId = userAcc.getUserId();
		if (userId == null) {
			userAcc.setActiveSw("Y");
		}
		
		userAccRepo.save(userAcc);
		if (userId == null) {
			return "user is saved";
		} else {
			return "user is updated";
		}
	}

	@Override
	public List<UserAccount> getAllUserAccounts() {
		return userAccRepo.findAll();
	}

	@Override
	public UserAccount getUserAcc(Integer userId) {
		Optional<UserAccount> findById = userAccRepo.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;

	}

	@Override
	public boolean deleteUserAcc(Integer userId) {
		try {
			userAccRepo.deleteById(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUserAccStatus(Integer userId, String status) {
		try {
			userAccRepo.updateUserAccStatus(userId, status);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}
