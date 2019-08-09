package com.jle.alexandro.services.impl;

import javax.transaction.Transactional;

import com.jle.alexandro.dao.ClientRepository;
import com.jle.alexandro.dao.CountryRepository;
import com.jle.alexandro.dao.PaymentMethodRepository;
import com.jle.alexandro.dao.TitleRepository;
import com.jle.alexandro.models.RegistrationForm;
import com.jle.alexandro.models.entities.*;
import com.jle.alexandro.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private ClientRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public Client register(RegistrationForm data) {
        String username = data.getUsername();
        Client user = findUserByUsername(username);

        if(user != null) throw new RuntimeException("This user already exists, Try with an other username");

        Client newUser = new Client();
        newUser.setFirstName(data.getFirstName());
        newUser.setLastName(data.getLastName());
        newUser.setEmail(username);
        newUser.setPassword(data.getPassword());

        addDummies(newUser);

        return saveUser(newUser);
    }

    @Override
    public Client saveUser(Client user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Client findUserByUsername(String username) {
        return userRepository.findClientByEmail(username);
    }

    // FIXME : Add dummies data as some fields are not sent by frontend and doesn't accept null in database
    private Client addDummies(Client user) {

        Title dummyTitle = titleRepository.findFirstByIdGreaterThanEqual(1);
        Country dummyCountry = countryRepository.findFirstByIdGreaterThanEqual(1);
        PaymentMethod dummyPaymentMethod = paymentMethodRepository.findFirstByIdGreaterThanEqual(1);


        Address invoiceAddress = new Address();
        invoiceAddress.setAddressLine1("Line1");
        invoiceAddress.setAddressLine2("Line2");
        invoiceAddress.setCity("City");
        invoiceAddress.setState("State");
        invoiceAddress.setPostalCode("PostalCode");
        invoiceAddress.setCountryByCountryId(dummyCountry);

        Address deliveryAddress = new Address();
        deliveryAddress.setAddressLine1("Line1");
        deliveryAddress.setAddressLine2("Line2");
        deliveryAddress.setCity("City");
        deliveryAddress.setState("State");
        deliveryAddress.setPostalCode("PostalCode");
        deliveryAddress.setCountryByCountryId(dummyCountry);

        user.setTitleByTitleId(dummyTitle);
        user.setPhone("+00 000000");
        user.setAddressByInvoiceAddressId(invoiceAddress);
        user.setAddressByDeliveryAddressId(deliveryAddress);
        user.setPaymentMethodByPaymentMethodId( dummyPaymentMethod );

        return user;
    }
}
