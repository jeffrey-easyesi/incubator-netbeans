/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.core.startup;

import org.netbeans.ModuleManager;
import org.netbeans.junit.MockServices;
import org.netbeans.junit.NbTestCase;
import org.openide.util.Lookup;

/**
 * @author Radek Matous
 */
public class MockServicesTest extends NbTestCase {
    private ModuleManager mgr;
    public MockServicesTest(String testName) {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        mgr = org.netbeans.core.startup.Main.getModuleSystem().getManager();                
        MockServices.setServices(MyServices.class);
    }

    public void testIfMyServiceIsReachable() {
        assertNotNull(Lookup.getDefault().lookup(MyServices.class));
        assertNotNull(mgr);
    }
        
    public static final class MyServices {}
}
