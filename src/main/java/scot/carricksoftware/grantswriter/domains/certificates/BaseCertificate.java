/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates;

import jakarta.persistence.Column;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.places.Organisation;
import scot.carricksoftware.grantswriter.enums.certificates.CertificateType;


@MappedSuperclass
public class BaseCertificate extends BaseEntity {

    @Column(name = "`certificate_number`")
    private String certificateNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "`certificate_type`")
    private CertificateType certificateType;

    @ManyToOne
    @JoinColumn(name = "`organisation_id`")
    private Organisation certificateSource;

    @Column(name= "`certificate_date`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_FORMAT)
    private String certificateDate;

    @ManyToOne
    @JoinColumn(name = "`registration_authority`")
    private Organisation registrationAuthority;

    @Column(name = "`volume`")
    private String volume;

    @Column(name = "`number`")
    private String number;

    public String getCertificateNumber() {
        return certificateNumber;
    }

    @SuppressWarnings("unused")
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public Organisation getCertificateSource() {
        return certificateSource;
    }

    public String getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(String certificateDate) {
        this.certificateDate = certificateDate;
    }

    public void setCertificateSource(Organisation organisation) {
        this.certificateSource = organisation;
    }

    public CertificateType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }

    public Organisation getRegistrationAuthority() {
        return registrationAuthority;
    }

    public void setRegistrationAuthority(Organisation registrationAuthority) {
        this.registrationAuthority = registrationAuthority;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
}
