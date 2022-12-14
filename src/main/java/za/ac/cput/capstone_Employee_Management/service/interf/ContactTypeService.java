package za.ac.cput.capstone_Employee_Management.service.interf;

import za.ac.cput.capstone_Employee_Management.domain.ContactType;

import java.util.List;

public interface ContactTypeService extends IService <ContactType,Long>{
    List<ContactType> findAll();
    void deleteByID(Long ID);
    ContactType findByEmail(String email);
}
