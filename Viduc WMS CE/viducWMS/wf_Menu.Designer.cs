namespace viducWMS
{
    partial class wf_Menu
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(wf_Menu));
            this.btnInventario = new System.Windows.Forms.PictureBox();
            this.btnRecepcion = new System.Windows.Forms.PictureBox();
            this.btnTransalado = new System.Windows.Forms.PictureBox();
            this.btnCerrar = new System.Windows.Forms.PictureBox();
            this.btnDespacho = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.btnConteoFisico = new System.Windows.Forms.PictureBox();
            this.SuspendLayout();
            // 
            // btnInventario
            // 
            this.btnInventario.BackColor = System.Drawing.SystemColors.Control;
            this.btnInventario.Image = ((System.Drawing.Image)(resources.GetObject("btnInventario.Image")));
            this.btnInventario.Location = new System.Drawing.Point(10, 157);
            this.btnInventario.Name = "btnInventario";
            this.btnInventario.Size = new System.Drawing.Size(218, 30);
            this.btnInventario.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnInventario.Tag = "Inventario y Búsqueda";
            this.btnInventario.Click += new System.EventHandler(this.btnInventario_Click);
            // 
            // btnRecepcion
            // 
            this.btnRecepcion.BackColor = System.Drawing.SystemColors.Control;
            this.btnRecepcion.Image = ((System.Drawing.Image)(resources.GetObject("btnRecepcion.Image")));
            this.btnRecepcion.Location = new System.Drawing.Point(10, 47);
            this.btnRecepcion.Name = "btnRecepcion";
            this.btnRecepcion.Size = new System.Drawing.Size(218, 30);
            this.btnRecepcion.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnRecepcion.Tag = "Recepción Producto";
            this.btnRecepcion.Click += new System.EventHandler(this.btnRecepcion_Click);
            // 
            // btnTransalado
            // 
            this.btnTransalado.BackColor = System.Drawing.Color.Transparent;
            this.btnTransalado.Image = ((System.Drawing.Image)(resources.GetObject("btnTransalado.Image")));
            this.btnTransalado.Location = new System.Drawing.Point(10, 84);
            this.btnTransalado.Name = "btnTransalado";
            this.btnTransalado.Size = new System.Drawing.Size(218, 30);
            this.btnTransalado.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnTransalado.Tag = "Transalado Producto";
            this.btnTransalado.Click += new System.EventHandler(this.btnTransalado_Click);
            // 
            // btnCerrar
            // 
            this.btnCerrar.BackColor = System.Drawing.SystemColors.Control;
            this.btnCerrar.Image = ((System.Drawing.Image)(resources.GetObject("btnCerrar.Image")));
            this.btnCerrar.Location = new System.Drawing.Point(10, 230);
            this.btnCerrar.Name = "btnCerrar";
            this.btnCerrar.Size = new System.Drawing.Size(218, 30);
            this.btnCerrar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnCerrar.Tag = "Salir";
            this.btnCerrar.Click += new System.EventHandler(this.btnCerrar_Click);
            // 
            // btnDespacho
            // 
            this.btnDespacho.Image = ((System.Drawing.Image)(resources.GetObject("btnDespacho.Image")));
            this.btnDespacho.Location = new System.Drawing.Point(10, 120);
            this.btnDespacho.Name = "btnDespacho";
            this.btnDespacho.Size = new System.Drawing.Size(218, 30);
            this.btnDespacho.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnDespacho.Click += new System.EventHandler(this.btnDespacho_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(102, 1);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(130, 33);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            // 
            // btnConteoFisico
            // 
            this.btnConteoFisico.BackColor = System.Drawing.SystemColors.Control;
            this.btnConteoFisico.Image = ((System.Drawing.Image)(resources.GetObject("btnConteoFisico.Image")));
            this.btnConteoFisico.Location = new System.Drawing.Point(10, 194);
            this.btnConteoFisico.Name = "btnConteoFisico";
            this.btnConteoFisico.Size = new System.Drawing.Size(218, 30);
            this.btnConteoFisico.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.btnConteoFisico.Tag = "Inventario y Búsqueda";
            this.btnConteoFisico.Click += new System.EventHandler(this.btnConteoFisico_Click);
            // 
            // wf_Menu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.ControlBox = false;
            this.Controls.Add(this.btnConteoFisico);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnDespacho);
            this.Controls.Add(this.btnCerrar);
            this.Controls.Add(this.btnTransalado);
            this.Controls.Add(this.btnRecepcion);
            this.Controls.Add(this.btnInventario);
            this.Name = "wf_Menu";
            this.Text = "Menú Viduc";
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.wf_Menu_KeyPress);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox btnInventario;
        private System.Windows.Forms.PictureBox btnRecepcion;
        private System.Windows.Forms.PictureBox btnTransalado;
        private System.Windows.Forms.PictureBox btnCerrar;
        private System.Windows.Forms.PictureBox btnDespacho;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox btnConteoFisico;
    }
}