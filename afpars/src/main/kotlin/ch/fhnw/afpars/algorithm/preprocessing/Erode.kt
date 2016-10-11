package ch.fhnw.afpars.algorithm.preprocessing

import ch.fhnw.afpars.model.AFImage
import org.opencv.core.Mat
import org.opencv.core.Size
import org.opencv.imgproc.Imgproc

class Erode:IPreprocessingAlgorithm{
    val erosionSize:Int

    constructor(erosionSize: Int){
        this.erosionSize = erosionSize
    }

    override fun run(image: AFImage): AFImage {
        return run(image, erosionSize)
    }

    fun run(imageAF: AFImage, erosionSize:Int): AFImage {
        val element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, Size(2.0 * erosionSize + 1.0, 2.0 * erosionSize + 1.0))
        val result = AFImage(Mat())
        Imgproc.erode(imageAF.image, result.image, element)
        return result
    }

}