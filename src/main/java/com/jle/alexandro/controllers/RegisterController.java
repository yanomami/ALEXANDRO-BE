package com.jle.alexandro.controllers;

import com.jle.alexandro.config.JwtTokenUtil;
import com.jle.alexandro.dao.CountryRepository;
import com.jle.alexandro.dao.PaymentMethodRepository;
import com.jle.alexandro.dao.TitleRepository;
import com.jle.alexandro.models.ApiResponse;
import com.jle.alexandro.models.AuthToken;
import com.jle.alexandro.models.RegistrationForm;
import com.jle.alexandro.models.entities.*;
import com.jle.alexandro.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody RegistrationForm data) throws AuthenticationException {

        String username = data.getUsername();
        Client user = accountService.findUserByUsername(username);

        if(user != null) throw new RuntimeException("This user already exists, Try with an other username");

        Client newUser = new Client();
        newUser.setFirstName(data.getFirstName());
        newUser.setLastName(data.getLastName());
        newUser.setEmail(username);
        newUser.setPassword(data.getPassword());

        addDummies(newUser);

        final Client addedUser = accountService.saveUser(newUser);
        final String token = jwtTokenUtil.generateToken(addedUser);
        return new ApiResponse<>(200, "success",new AuthToken(token, addedUser.getEmail()));
    }

    // FIXME : Add dummies data as some fields are not sent by frontend and doesn't accept null in database
    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

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
