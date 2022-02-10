package com.n0s08bz.demo.product;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.SolrClientFactory;
import org.springframework.data.solr.server.support.HttpSolrClientFactory;

@Configuration
@EnableSolrRepositories(
        basePackages = "com.n0s08bz.demo.product")
@ComponentScan
public class SolrConfig {

    /*@Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder("http://localhost:8983/solr").build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }*/

    @Bean
    SolrTemplate solrTemplate() {
        return new SolrTemplate(solrServerFactory());
    }

    @Bean
    SolrClientFactory solrServerFactory() {

        Credentials credentials = new UsernamePasswordCredentials("solr", "");
        return new HttpSolrClientFactory(solrServer());
    }

    @Bean
    SolrClient solrServer() {
        return new HttpSolrClient.Builder("http://localhost:8983/solr").build();
    }
}

