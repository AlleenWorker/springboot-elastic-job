package com.allen.autoconfig.zookeeper;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zk 自动化配置
 *
 * @author allen
 * @date 2020/5/30 16:01
 */
@Configuration
@ConditionalOnProperty("elasticjob.zookeeper.server-list")
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperAutoConfig {

    @Autowired
    private ZookeeperProperties zkProperties;

    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter zkCent() {
        ZookeeperConfiguration zkConfiguration =
                new ZookeeperConfiguration(zkProperties.getServerList(), zkProperties.getNamespace());
        ZookeeperRegistryCenter zkRegistryCenter =
                new ZookeeperRegistryCenter(zkConfiguration);
        return zkRegistryCenter;
    }

}