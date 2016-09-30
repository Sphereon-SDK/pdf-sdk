/* 
 * Sphereon :: DOC :: PDF
 *
 * <b>The PDF conversion API 'image2pdf' converts images to (searcheable) PDF files.</b>    The flow is generally as follows:  1. First upload an image using the /image2pdf POST endpoint. You will get back a response that contains a job with its associated settings.  2. Start the job from a PUT request to the /image2pdf/{jobid} endpoint, with the Job and Settings JSON as request body. The conversion to PDF will now start  3. Check the job status from the /image2pdf/{jobid} GET endpoint until the status has changed to DONE or ERROR. Messaging using a websocket will be available as an alternative in a future version  4. Retrieve the PDF file using the /image2pdf/{jobid}/stream GET endpoint. This will return the PDF file only when the status is DONE. In other cases it will return the Job Response JSON (with http code 202 instead of 200)      <b>Interactive testing: </b>A web based test console is available in the <a href=\"https://store.sphereon.com\">Sphereon API Store</a>
 *
 * OpenAPI spec version: 0.1.4
 * Contact: dev@sphereon.com
 * Generated by: https://github.com/swagger-api/swagger-codegen.git
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


using NUnit.Framework;

using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using Sphereon.SDK.Pdf.Api;
using Sphereon.SDK.Pdf.Model;
using Sphereon.SDK.Pdf.Client;
using System.Reflection;

namespace Sphereon.SDK.Pdf.Test
{
    /// <summary>
    ///  Class for testing PDFJob
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by Swagger Codegen.
    /// Please update the test case below to test the model.
    /// </remarks>
    [TestFixture]
    public class PDFJobTests
    {
        // TODO uncomment below to declare an instance variable for PDFJob
        //private PDFJob instance;

        /// <summary>
        /// Setup before each test
        /// </summary>
        [SetUp]
        public void Init()
        {
            // TODO uncomment below to create an instance of PDFJob
            //instance = new PDFJob();
        }

        /// <summary>
        /// Clean up after each test
        /// </summary>
        [TearDown]
        public void Cleanup()
        {

        }

        /// <summary>
        /// Test an instance of PDFJob
        /// </summary>
        [Test]
        public void PDFJobInstanceTest()
        {
            // TODO uncomment below to test "IsInstanceOfType" PDFJob
            //Assert.IsInstanceOfType<PDFJob> (instance, "variable 'instance' is a PDFJob");
        }

        /// <summary>
        /// Test the property 'JobId'
        /// </summary>
        [Test]
        public void JobIdTest()
        {
            // TODO unit test for the property 'JobId'
        }
        /// <summary>
        /// Test the property 'Settings'
        /// </summary>
        [Test]
        public void SettingsTest()
        {
            // TODO unit test for the property 'Settings'
        }

    }

}
