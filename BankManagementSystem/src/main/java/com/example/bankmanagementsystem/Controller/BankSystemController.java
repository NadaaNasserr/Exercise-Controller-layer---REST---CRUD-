package com.example.bankmanagementsystem.Controller;
import com.example.bankmanagementsystem.APIResponse.APIResponse;
import com.example.bankmanagementsystem.Model.BankSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class BankSystemController {

    ArrayList<BankSystem> bankSystems = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<BankSystem> getCustomers() {

        return bankSystems;
    }

    @PostMapping("/add")
    public APIResponse addCustomers(@RequestBody BankSystem bankSystem) {
        bankSystems.add(bankSystem);
        return new APIResponse("Customers added", 200);

    }


    @PutMapping("/update/{index}")
    public APIResponse updateCustomers(@PathVariable int index, @RequestBody BankSystem bankSystem) {
        bankSystems.set(index, bankSystem);
        return new APIResponse("Customers updated", 200);


    }

    @DeleteMapping("/delete/{index}")
    public APIResponse deleteCustomers(@PathVariable int index) {
        bankSystems.remove(index);
        return new APIResponse("Customers deleted", 200);


    }

    @PutMapping("/deposit/{amount}/{index}")
    public APIResponse deposit(@PathVariable int amount, @PathVariable int index) {

        bankSystems.get(index).setBalance(bankSystems.get(index).getBalance() + amount);
        return new APIResponse("deposit", 200);

    }

    @PutMapping("/withdraw/{amount}/{index}")
    public APIResponse withdraw(@PathVariable int amount, @PathVariable int index) {

        if (bankSystems.get(index).getBalance() >= amount) {
            bankSystems.get(index).setBalance(bankSystems.get(index).getBalance() - amount);
            return new APIResponse("withdraw", 200);

        }
        return new APIResponse("Not Found", 404);

    }
}
