Set obj = CreateObject("Convert2PDFLib.Convert2Pdf")
obj.SetAccessToken "xxx"
obj.SetOcr true
obj.SetEngine "PREMIUM"
obj.Convert "c:\\temp\\image.tif", "C:\\temp\\result.pdf" 