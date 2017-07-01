package com.mercury.platform.shared.config.configration;


import java.util.List;

public interface ListConfigurationService<T> extends ConfigurationService,HasDefault<List<T>> {
    List<T> getEntities();
}
