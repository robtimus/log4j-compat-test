/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

module log4j3.test {

    exports test.log4j3;

    opens test.log4j3 to org.junit.platform.commons;

    requires test.log4j.plugin;
    requires transitive org.junit.jupiter.api;
    requires transitive org.junit.jupiter.engine;
    requires transitive org.junit.jupiter.params;
    requires transitive org.junit.platform.commons;
    requires transitive org.junit.platform.engine;
    requires org.apache.logging.log4j.plugins;

    provides org.apache.logging.log4j.plugins.model.PluginService with test.log4j3.plugins.Log4jPlugins;
}