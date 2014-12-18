/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * This package contains utility classes designed to test Accumulo when large cells are being written. This is an attempt to observe the behavior Accumulo
 * displays when compacting and reading these cells.
 * 
 * There are two components to this package: {@link org.apache.accumulo.test.stress.random.Write} and {@link org.apache.accumulo.test.stress.random.Scan}.
 * 
 * The {@link org.apache.accumulo.test.stress.random.Write} provides facilities for writing random sized cells. Users can configure minimum and maximum
 * sized portions of a cell. The portions users can configure are the row, column family, column qualifier and value. Note that the sizes are uniformly
 * distributed between the minimum and maximum values. See {@link org.apache.accumulo.test.stress.random.WriteOptions} for available options and default sizing
 * information.
 * 
 * The Scan provides users with the ability to query tables generated by the Write. It will pick a tablet at random and scan the entire range. The
 * amount of times this process is done is user configurable. By default, it happens 1,024 times. Users can also specify whether or not the scan should be
 * isolated or not.
 * 
 * There is no shared state intended by either of these services. This allows multiple clients to be run in parallel, either on the same host or distributed
 * across hosts.
 */
package org.apache.accumulo.test.stress.random;
