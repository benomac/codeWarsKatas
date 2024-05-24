val a = """ImageMetadataWithLocation(ImageMetadata(f8a841ce-090d-4b78-93cd-639235c1ee02,10,3,entity type = series, entity id = 7zyvc23, class = I, streaming platform = itv_hub, distribution partner key = sky_od,resolution = 1x4451 (aspect ratio = 1:4451, pixel count = 4451 pixels), file size = 1453, format = png,Some(ImageTreatment(8,l)),2022-10-26T12:22:52.238469Z,Md5HexString(z),Some(AltText(Mock Alternative Text))),s3://A/x)
  |""".stripMargin

val b = """ImageMetadataWithLocation(ImageMetadata(f8a841ce-090d-4b78-93cd-639235c1ee02,10,3,entity type = series, entity id = 7zyvc23, class = I, streaming platform = itv_hub, distribution partner key = sky_od,resolution = 1x4451 (aspect ratio = 1:4451, pixel count = 4451 pixels), file size = 1453, format = png,Some(ImageTreatment(8,l)),2022-10-26T12:22:52.238469Z,Md5HexString(z),Some(AltText(Mock Alternative Text))),s3://A/x)
  |""".stripMargin

a == b