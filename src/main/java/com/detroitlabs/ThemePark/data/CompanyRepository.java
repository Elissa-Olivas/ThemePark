package com.detroitlabs.ThemePark.data;

import com.detroitlabs.ThemePark.model.Company;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CompanyRepository {

    private Company companyInfo = new Company("Gisney Land", "contact@gisneyland.com", "719-123-4567", "1313 Disneyland Dr, Colorado Springs, CO 80910");

    public Company getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(Company companyInfo) {
        this.companyInfo = companyInfo;
    }
}
