/*
 * Copyright (c)  04 Feb 2025, Andrew Grant of Carrick Software .
 * All rights reserved.
 */

package scot.carricksoftware.grants;

import org.springframework.stereotype.Component;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.birthcertificates.BirthCertificateCommandImpl;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.deathcertificates.DeathCertificateCommandImpl;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.marriagecertificates.MarriageCertificateCommandImpl;
import scot.carricksoftware.grants.domains.certificates.BirthCertificate;
import scot.carricksoftware.grants.domains.certificates.DeathCertificate;
import scot.carricksoftware.grants.domains.certificates.DivorceCertificate;
import scot.carricksoftware.grants.domains.certificates.MarriageCertificate;

import java.util.Random;

import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

@SuppressWarnings("unused")
@Component
public class GenerateCertificateRandomValues {

    private static final Random rand = new Random();
    @SuppressWarnings("SpellCheckingInspection")
    private static final String[] names = {"Ryland", "Oscar", "Martha", "Brynn"
            , "Euan", "Jack", "Ramsay", "Ally"};


    public static String GetRandomString() {
        int random = rand.nextInt(names.length);
        return names[random];
    }

    public static BirthCertificate GetRandomBirthCertificate() {
        BirthCertificate birthCertificate = new BirthCertificate();
        birthCertificate.setId(GetRandomLong());
        return birthCertificate;
    }

    public static BirthCertificateCommand GetRandomBirthCertificateCommand() {
        BirthCertificateCommand birthCertificateCommand = new BirthCertificateCommandImpl();
        birthCertificateCommand.setId(GetRandomLong());
        return birthCertificateCommand;
    }

    public static DeathCertificate GetRandomDeathCertificate() {
        DeathCertificate deathCertificate = new DeathCertificate();
        deathCertificate.setId(GetRandomLong());
        return deathCertificate;
    }

    public static DeathCertificateCommand GetRandomDeathCertificateCommand() {
        DeathCertificateCommand deathCertificateCommand = new DeathCertificateCommandImpl();
        deathCertificateCommand.setId(GetRandomLong());
        return deathCertificateCommand;
    }

    public static MarriageCertificate GetRandomMarriageCertificate() {
        MarriageCertificate marriageCertificate = new MarriageCertificate();
        marriageCertificate.setId(GetRandomLong());
        return marriageCertificate;
    }

    public static MarriageCertificateCommand GetRandomMarriageCertificateCommand() {
        MarriageCertificateCommand marriageCertificateCommand = new MarriageCertificateCommandImpl();
        marriageCertificateCommand.setId(GetRandomLong());
        return marriageCertificateCommand;
    }

    public static DivorceCertificate GetRandomDivorceCertificate() {
        DivorceCertificate divorceCertificate = new DivorceCertificate();
        divorceCertificate.setId(GetRandomLong());
        return divorceCertificate;
    }

    public static DivorceCertificateCommand GetRandomDivorceCertificateCommand() {
        DivorceCertificateCommand divorceCertificateCommand = new DivorceCertificateCommandImpl();
        divorceCertificateCommand.setId(GetRandomLong());
        return divorceCertificateCommand;
    }

}
