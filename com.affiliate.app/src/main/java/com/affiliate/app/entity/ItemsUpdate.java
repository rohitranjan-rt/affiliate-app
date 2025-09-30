package com.affiliate.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsUpdate {

    private String title;

    private String affiliateUrl;

    private String imageUrl;

}
