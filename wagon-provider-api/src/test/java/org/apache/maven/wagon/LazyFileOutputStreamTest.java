package org.apache.maven.wagon;

/* ====================================================================
 *   Copyright 2001-2004 The Apache Software Foundation.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * ====================================================================
 */

import junit.framework.TestCase;
import org.apache.maven.wagon.util.FileUtils;

import java.io.File;

/**
 * @author <a href="mailto:mmaczka@interia.pl">Michal Maczka</a> 
 * @version $Id$ 
 */
public class LazyFileOutputStreamTest extends TestCase
{

     public void testFileCreation() throws Exception
     {
         File file = FileTestUtils.createUniqueFile( getName() );
             
         file.deleteOnExit();

         assertFalse( file.exists() );

         LazyFileOutputStream stream = new LazyFileOutputStream( file );

         assertFalse( file.exists() );

         String exptected = "michal";

         stream.write( exptected.getBytes() );

         stream.close();

         assertTrue( file.exists() );

         String actual = FileUtils.fileRead( file );

         assertEquals( exptected, actual );

     
     }
     
}
