/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kkp.myapp.views.events;

import java.util.EventListener;

public interface DataEventListener extends EventListener{
    public void actionPerformed(String action, Object data);
}
