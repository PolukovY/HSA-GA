package com.levik.transactions.client.model;

import lombok.Builder;

/**
 * Limits:
 * Google Analytics Collection Limits and Quotas
 *
 * API details:
 * https://developers.google.com/analytics/devguides/collection/protocol/v1/devguide
 *
 * Page Tracking
 *
 * v=1              // Version.
 * &tid=UA-XXXXX-Y  // Tracking ID / Property ID.
 * &cid=555         // Anonymous Client ID.
 *
 * &t=pageview      // Pageview hit type.
 * &dh=mydemo.com   // Document hostname.
 * &dp=/home        // Page.
 * &dt=homepage     // Title.
 *
 * Event Tracking
 *
 * v=1              // Version.
 * &tid=UA-XXXXX-Y  // Tracking ID / Property ID.
 * &cid=555         // Anonymous Client ID.
 *
 * &t=event         // Event hit type
 * &ec=video        // Event Category. Required.
 * &ea=play         // Event Action. Required.
 * &el=holiday      // Event label.
 * &ev=300          // Event value.
 */
@Builder
public class GARequest {


    //for account and api configuration
    private int v;
    private String tid;

    //for user identity
    private String cid;

    //for Page Tracking
    private String dh;
    private String dp;
    private String dt;

    //for Event Tracking
    private String t;
    private String ec;
    private String ea;
    private String el;
    private String ev;
}
