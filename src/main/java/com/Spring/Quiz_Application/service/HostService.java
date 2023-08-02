package com.Spring.Quiz_Application.service;

import com.Spring.Quiz_Application.entity.Host;
import com.Spring.Quiz_Application.repository.HostRepository;
import org.springframework.stereotype.Service;

@Service
public class HostService {
    private HostRepository hostRepository;

    public Host getHostById(Long hostId) {
        return hostRepository.findById(hostId).orElse(null);
    }
}
