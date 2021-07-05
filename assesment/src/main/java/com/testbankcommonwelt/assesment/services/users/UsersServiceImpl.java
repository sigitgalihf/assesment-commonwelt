package com.testbankcommonwelt.assesment.services.users;
import com.google.api.client.util.ArrayMap;
import com.testbankcommonwelt.assesment.dto.UserDto;
import com.testbankcommonwelt.assesment.entities.Users;
import com.testbankcommonwelt.assesment.exceptions.ResourceNotFoundException;
import com.testbankcommonwelt.assesment.repositories.UsersRepository;
import com.testbankcommonwelt.assesment.requests.UserRequest;
import com.testbankcommonwelt.assesment.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Timestamp getSysDate()
    {
    	return usersRepository.getSysDate();
    }

	@Override
	public List<Object> findAllUsers() {
		List<Users> users = usersRepository.findAll();

		List<Object> arr = new ArrayList<>();
		users.forEach(data -> {
			Map<String, Object> user = new ArrayMap<>();
			user.put("id", data.getId());
			user.put("name", data.getName());
			user.put("phone", data.getPhone());
			arr.add(user);

		});
		return arr;
	}

	@Override
	public Response save(UserRequest userRequest) {
		Response response = null;
		Users users = new Users();
		Timestamp sysdate = usersRepository.getSysDate();
		users.setName(userRequest.getName());
		users.setPhone(userRequest.getPhone());
		users = usersRepository.save(users);
		UserDto userDto = new UserDto(
				users.getId(),
				users.getName(),
				users.getPhone());
		response = users != null ? new Response("Success", userDto) : new Response(null);
		return response;
	}



	@Override
	public Users findById(Long id) {
		return usersRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User not found!")
		);
	}

	@Override
	public Response updateUser(Long id, UserRequest userRequest) {
		Users users = this.findById(id);
		Timestamp sysdate = usersRepository.getSysDate();
		Response response = null;
		users.setName(userRequest.getName());
		users.setPhone(userRequest.getPhone());
		users = usersRepository.save(users);
		UserDto userDto = new UserDto(
				users.getId(),
				users.getName(),
				users.getPhone());
		response = users != null ? new Response("Success", userDto) : new Response(null);
		return response;
	}

	@Override
	public Response deleteUser(Long id) {
    	Response response = null;
		Users users = this.findById(id);
		usersRepository.deleteById(users.getId());
		UserDto userDto = new UserDto(
				users.getId(),
				users.getName(),
				users.getPhone());
		response = users != null ? new Response("Success", userDto) : new Response(null);
		return response;
	}


	@Override
	public Map<String, Object> findAllUsersPage(Integer pageNo, Integer pageSize, String sortBy, String sortDirection, String name) {
		Map<String, Object> result = new HashMap<>();

		Sort.Direction sort;
		if (sortBy.equalsIgnoreCase("desc"))
			sort = Sort.Direction.DESC;
		else
			sort = Sort.Direction.ASC;

		Page<Users> list = null;

		Pageable paging = PageRequest.of(pageNo, pageSize, sort, sortBy);

		if (name.equalsIgnoreCase(""))
			name = null;
		else
			name = "%" + name + "%";

		list = usersRepository.findAllUsers(name, paging);

		result.put("data", list.getContent());
		result.put("total_result", list.getTotalElements());
		result.put("total_page", list.getTotalPages());
		return result;
	}
}


