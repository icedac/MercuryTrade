package com.mercury.platform.shared.entity.message;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TradeNotificationDescriptor extends NotificationDescriptor {
    private String offer;
    private Double curCount;
    private String currency;
    private String league;

    private void Normalize() {
        if ( currency.equalsIgnoreCase("Alchemy Orb")) currency = "alch";
        if ( currency.equalsIgnoreCase("Alchemy")) currency = "alch";
        if ( currency.equalsIgnoreCase("Chaos Orb")) currency = "chaos";
        if ( currency.equalsIgnoreCase("Chaos")) currency = "chaos";
        if ( currency.equalsIgnoreCase("Exalted Orb")) currency = "exalt";
        if ( currency.equalsIgnoreCase("Exalted")) currency = "exalt";
        if ( currency.equalsIgnoreCase("Exalt")) currency = "exalt";
    }

    public boolean Valuable() {
        Normalize();

        if ( currency.equalsIgnoreCase( "chaos" ) && curCount > 20.0 ) {
            return true;
        }
        if ( currency.equalsIgnoreCase( "exalt" ) && curCount > 0.2 ) {
            return true;
        }
        if ( currency.equalsIgnoreCase( "alch" ) && curCount > 30.0 ) {
            return true;
        }
        return false;
    }
}
